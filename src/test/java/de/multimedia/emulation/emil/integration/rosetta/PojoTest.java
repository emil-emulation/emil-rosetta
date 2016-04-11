package de.multimedia.emulation.emil.integration.rosetta;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterPackageInfo;
import static com.openpojo.reflection.impl.PojoClassFactory.getPojoClasses;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public class PojoTest {

  @Test
  public void testGetterAndSetter() {
    Validator validator = ValidatorBuilder.create()
        .with(new SetterTester())
        .with(new GetterTester())
        .build();
    FilterPackageInfo filterPackageInfo = new FilterPackageInfo();

    List<PojoClass> pojoClasses = new ArrayList<>();
    pojoClasses.addAll(getPojoClasses("de.multimedia.emulation.emil.integration.rosetta.model", filterPackageInfo));
    // pojoClasses.addAll(getPojoClassesRecursively("", filterPackageInfo));
    validator.validate(pojoClasses);
  }

}
