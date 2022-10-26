package pro.sky.skyprospring;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
    public String validateName(String name) {
        if (StringUtils.isAlpha(name)) {
            throw new IncorrectNameOfEmployee();
        }
        return StringUtils.capitalize(name.toLowerCase());
    }
    public String validateSureName(String surname ) {
        String[] surnames = surname.split("-");
        for (int i =0;i<surnames.length;i++) {
            if (StringUtils.isAlpha(surname)) {
                throw new IncorrectNameOfEmployee();
            }
            surnames[i] = StringUtils.capitalize(surname.toLowerCase());
        }
        return String.join("-", surname);
    }

}
