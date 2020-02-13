package springboot.scratch.restapi;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {

    private final Map<String, UserDto> users = new HashMap<>();

    @GetMapping(path = {"", "/{userId}"}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> getUser(
            @PathVariable(required = false) Optional<String> userId,
            @RequestParam(value = "page", required = false, defaultValue = "0") Optional<Integer> page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Optional<Integer> limit) {

        StringBuilder sb = new StringBuilder("getUser called ");
        sb = userId.isPresent() == true ? sb.append("with userId:").append(userId.get() + " ") : sb.append(" with userId null ");
        sb = page.isPresent() == true ? sb.append("with page:").append(page.get() + " ") : sb.append(" with page null ");
        sb = limit.isPresent() == true ? sb.append("with limit:").append(limit.get() + " ") : sb.append(" with limit null ");
        log.info(sb.toString());

        if (userId.isPresent() && users.containsKey(userId.get())) {
            return new ResponseEntity<>(users.get(userId.get()), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto userDto) {

        userDto.setUserId(UUID.randomUUID().toString());
        users.put(userDto.getUserId(), userDto);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return "updateUser called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "deleteUser called";
    }
}
