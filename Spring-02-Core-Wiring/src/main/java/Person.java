import jdk.jfr.DataAmount;
import jdk.jfr.SettingDefinition;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Person {
    private String name;
    private Car car;
}
