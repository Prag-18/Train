import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase12TrainConsistMgmtTest {

    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape, String cargo) {
            this.shape = shape;
            this.cargo = cargo;
        }
    }

    // Helper method
    private boolean checkSafety(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b ->
                !(b.shape.equals("Rectangular") && b.cargo.equals("Petroleum"))
        );
    }

    @Test
    public void testSafety_AllSafe() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal")
        );

        assertTrue(checkSafety(list));
    }

    @Test
    public void testSafety_UnsafeCase() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Rectangular", "Petroleum")
        );

        assertFalse(checkSafety(list));
    }

    @Test
    public void testSafety_MixedCases() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Gas"),
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Rectangular", "Petroleum") // unsafe
        );

        assertFalse(checkSafety(list));
    }

    @Test
    public void testSafety_EmptyList() {
        List<GoodsBogie> list = new ArrayList<>();

        assertTrue(checkSafety(list)); // no violations
    }

    @Test
    public void testSafety_OnlyRectangularSafeCargo() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Rectangular", "Wood")
        );

        assertTrue(checkSafety(list));
    }
}
