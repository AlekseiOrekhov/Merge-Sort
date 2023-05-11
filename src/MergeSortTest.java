import org.junit.*;

import static org.junit.Assert.*;

public class MergeSortTest {
    private MergeSort mergeSort;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before CalculatorTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After CalculatorTest.class");
    }

    @Before
    public void initTest() {
        mergeSort = new MergeSort();
    }

    @After
    public void afterTest() {
        mergeSort = null;
    }


    @Ignore("Message for ignored test")
    @Test
    public void ignoredTest() {
        System.out.println("will not print it");
    }

//    @Test(timeout = 500)
//    public void timeStampTest() {
//        while (true);
//    }

    @Test
    public void test1() throws Exception {
        checkInputAndOutput(new int[]{3, 5}, new int[]{3, 5});
    }

    @Test
//    @Ignore
    public void test2() throws Exception {
        checkInputAndOutput(new int[]{5, 3}, new int[]{3, 5});
    }

    private String getCurrentName() {
        return Thread.currentThread()
                .getStackTrace()[3]
                .getMethodName();
    }

    private void checkInputAndOutput(int[] input, int[] output) {
        String getCurrentName = getCurrentName();
        int[] res = mergeSort.sort(input);
        if (res.length != output.length) {
            System.out.println("Тест " + getCurrentName + " не прошел.");
            return;
        }

        for (int i  = 0; i < output.length; i++) {
            if (res[i] != output[i]) {
                System.out.println("Тест " + getCurrentName + " не прошел.");
                return;
            }
        }
        System.out.println("Тест " + getCurrentName + " прошел.");
    }

}