package cu.edu.cujae.backend.api.controller;

import cu.edu.cujae.backend.core.dto.GroupsDto;
import cu.edu.cujae.backend.core.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupsController {

    @Autowired
    private GroupsService groupsService;

    @GetMapping("")
    public ResponseEntity<List<GroupsDto>> getGroups() throws SQLException {
        List<GroupsDto> groupsList = groupsService.listGroups();
        return ResponseEntity.ok(groupsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupsDto> getGroupsById(@PathVariable String id) throws SQLException {
        GroupsDto groups = groupsService.getGroupsById(id);
        return ResponseEntity.ok(groups);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody GroupsDto groups) throws SQLException {
        groupsService.createGroups(groups);
        return ResponseEntity.ok("Groups Created");
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody GroupsDto groups) throws SQLException {
        groupsService.updateGroups(groups);
        return ResponseEntity.ok("Groups Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
        groupsService.deleteGroups(id);
        return ResponseEntity.ok("Groups deleted");
    }
}
