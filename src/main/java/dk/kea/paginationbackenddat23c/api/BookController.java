package dk.kea.paginationbackenddat23c.api;

import dk.kea.paginationbackenddat23c.JwtTokenManager;
import dk.kea.paginationbackenddat23c.service.IUserService;
import dk.kea.paginationbackenddat23c.entity.Book;
import dk.kea.paginationbackenddat23c.entity.JwtRequestModel;
import dk.kea.paginationbackenddat23c.entity.JwtResponseModel;
import dk.kea.paginationbackenddat23c.entity.User;
import dk.kea.paginationbackenddat23c.service.BookService;
import dk.kea.paginationbackenddat23c.service.JwtUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@NoArgsConstructor
//@RequestMapping("/api/books")
//@CrossOrigin(origins = "*", allowedHeaders = "*") //skal fjernes når config i Spring Security
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenManager jwtTokenManager;
    @Autowired
    private IUserService userService;

    @PostMapping("/signup")
    public ResponseEntity<JwtResponseModel> signup(@RequestBody JwtRequestModel request){
        System.out.println("signup: username:" + request.getUsername() + " password: " + request.getPassword() );
        User user = new User(request.getUsername(),request.getPassword());
        if(userService.findByName(user.getUsername()).size()==0) {
            if (userService.save(user) != null) {
                return ResponseEntity.ok(new JwtResponseModel("created user: " + user.getUsername() + " pw: " + user.getPassword()));
            } else {
                return ResponseEntity.ok(new JwtResponseModel("error creating user: " + user.getUsername()));
            }
        }else {
            return ResponseEntity.ok(new JwtResponseModel("error: user exists: " + user.getUsername()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseModel> createToken(@RequestBody JwtRequestModel request) throws Exception {
        // HttpServletRequest servletRequest is available from Spring, if needed.
        System.out.println(" JwtController createToken Call: 4" + request.getUsername());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(),
                            request.getPassword())
            );
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            return ResponseEntity.ok(new JwtResponseModel("bad credentials"));
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwtToken = jwtTokenManager.generateJwtToken(userDetails);
        return ResponseEntity.ok(new JwtResponseModel(jwtToken));
    }


    @PostMapping("/getSecret")
    public ResponseEntity<Map> getSecret() {
        System.out.println("getSecret is called");
        Map<String,String > map = new HashMap<>();
        map.put("message","this is secret from server");
        return ResponseEntity.ok(map);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Map> deleteUser(@RequestBody User user) { // hvis man kommer hertil, er token OK
        System.out.println("deleteUser is called with user: " + user.getUsername());
        // evt. findById, som finder hele objektet fra MySQL, inkl. id.
        List<User> users =  userService.findByName(user.getUsername());
        User userToDelete = users.get(0);
        userService.delete(userToDelete);
        Map<String,String > map = new HashMap<>();
        map.put("message","user deleted, if found " + user.getUsername());
        return ResponseEntity.ok(map);
    }

    @GetMapping("/api/books")
    public Page<Book> getAllBooks(Pageable pageable) {
        return bookService.getAllBooks(pageable);
    }
}
