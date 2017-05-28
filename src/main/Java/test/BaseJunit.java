package test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * base test case
 *
 * Created by sunny-chen on 2017/5/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/application*.xml"})
public class BaseJunit {

}
