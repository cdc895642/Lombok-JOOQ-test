package model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class LombokTest {

  @Getter
  @Setter
  private int id;
}
