package com.buddhi.multiplelibrary.membershipservice.controller;

import com.buddhi.multiplelibrary.comman.models.membership.Membership;
import com.buddhi.multiplelibrary.membershipservice.errors.NotFoundException;
import com.buddhi.multiplelibrary.membershipservice.repository.MembershipRepository;
import com.buddhi.multiplelibrary.membershipservice.service.MembershipService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @Autowired
    private MembershipRepository membershipRepository;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    @ResponseBody
    public String welcome() {
        return ("Welcome to Membership Service.");
    }


    @GetMapping("/member/{memberID}")
    public ResponseEntity<JSONObject> getMemberById(@PathVariable(value = "memberID") Long memberID){
        Membership memeber =  membershipRepository.findById(memberID)
                .orElseThrow(() -> new NotFoundException(String.format("Member not found")));

        return ResponseEntity.ok().body(memberDetails(memeber));
    }

//    @RequestMapping(
//            value = "/members",
//            method = RequestMethod.GET,
//            produces = { MediaType.APPLICATION_JSON_VALUE}
//    )
//
//    @ResponseBody
//    public List<Membership> getEmployees() {
//        List<Membership> list = membershipRepository.findAll();
//        return list;
//    }

    @RequestMapping(
            value = "/member",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE}
    )
    public Membership saveMembership(@RequestBody Membership membership){
        return membershipRepository.save(membership);
    }

    @PutMapping("/member/{id}")
    public ResponseEntity<JSONObject> updateMember(@PathVariable(value = "id") Long memberId,
                                           @RequestBody Membership memberDetails) throws IllegalArgumentException, javassist.NotFoundException {

        Membership member = membershipRepository.findById(memberId)
                .orElseThrow(() ->
                        new javassist.NotFoundException(String.format("Member not found for this id :: " + memberId))
                );

        member.setEmail(memberDetails.getEmail());
        member.setFirstName(memberDetails.getFirstName());
        member.setLastName(memberDetails.getLastName());
        member.setMembershipType(memberDetails.getMembershipType());
        member.setNic(memberDetails.getNic());
        member.setTelephone(memberDetails.getTelephone());
        final Membership updatedMember = membershipRepository.save(member);

        return ResponseEntity.ok(memberDetails(updatedMember));
    }

    private JSONObject memberDetails(Membership member) {
        JSONObject full_details = new JSONObject();
        full_details.put("firstName",member.getFirstName());
        full_details.put("lastName",member.getLastName());
        full_details.put("email",member.getEmail());
        full_details.put("telephone",member.getTelephone());
        full_details.put("nic",member.getNic());
        full_details.put("membershipType",member.getMembershipType());
        return full_details;
    }
}
