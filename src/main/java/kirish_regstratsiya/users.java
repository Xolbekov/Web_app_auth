package kirish_regstratsiya;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.xml.ws.soap.Addressing;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class users {
    private String ism;
    private String familiya;
    private String tel_nomer;
    private String login;
    private String parol;
}
