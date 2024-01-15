package by.tms.delivery.web;

import by.tms.delivery.dto.request.UpdateUserDTO;
import by.tms.delivery.entity.user.User;
import by.tms.delivery.mapper.MyMapper;
import by.tms.delivery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final MyMapper createMyMapper;


    @PutMapping("/{id}/update")
    public ResponseEntity<User> update(@Validated @RequestBody UpdateUserDTO updateUserDTO,
                                                  @RequestBody User user) {

        user = userService.update(createMyMapper.mapToUser(updateUserDTO));

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<User> deleteById(@PathVariable(name = "userId") Long id){
        if(userService.findById(id).isPresent()){
            userService.deleteById(id);
        }
        return ResponseEntity.ok().build();
    }
}
