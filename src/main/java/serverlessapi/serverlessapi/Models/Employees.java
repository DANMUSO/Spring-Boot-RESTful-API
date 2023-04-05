package serverlessapi.serverlessapi.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString


public class Employees {

    private String name;
    private Long age;
    private String location;
    private String email;
    private String department;
    private String phonenumber;
}
