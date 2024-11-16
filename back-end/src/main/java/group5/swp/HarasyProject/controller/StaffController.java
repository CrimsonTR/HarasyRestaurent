package group5.swp.HarasyProject.controller;

import group5.swp.HarasyProject.dto.request.staff.StaffRequest;
import group5.swp.HarasyProject.dto.response.ApiResponse;
import group5.swp.HarasyProject.dto.response.staff.StaffResponse;
import group5.swp.HarasyProject.enums.Account.StaffRole;
import group5.swp.HarasyProject.service.StaffService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StaffController {

    StaffService staffService;

    @GetMapping("/staff")
    public ApiResponse<List<StaffResponse>> getActiveStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/sorted")
    public ApiResponse<List<StaffResponse>> getStaffSortedByRole() {
        return staffService.getStaffSortedByRole();
    }

    @GetMapping("/staff/{role}")
    public ApiResponse<List<StaffResponse>> searchStaffByRole(@PathVariable StaffRole role) {
        return  staffService.searchStaffByRole(role);
    }

    @PutMapping("/staff/{id}")
    public ApiResponse<StaffResponse> updateStaff(@PathVariable Integer id, @RequestBody StaffRequest staffRequest) {
        return staffService.updateStaffInfo(id, staffRequest);
    }

    @PutMapping("/staff/deactivate/{id}")
    public ApiResponse<StaffResponse> deactiveStaff(@PathVariable Integer id) {
        return staffService.deactiveStaff(id);
    }
}
