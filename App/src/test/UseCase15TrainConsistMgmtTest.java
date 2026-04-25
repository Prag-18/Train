import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmtTest {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String msg) {
            super(msg);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo");
            }
            this.cargo = cargo;
        }
    }

    @Test
    public void testSafeAssignment() {
        GoodsBogie b = new GoodsBogie("Cylindrical");
        b.assignCargo("Petroleum");

        assertEquals("Petroleum", b.cargo);
    }

    @Test
    public void testUnsafeAssignment() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        assertThrows(CargoSafetyException.class, () -> b.assignCargo("Petroleum"));
    }

    @Test
    public void testDifferentCargoSafe() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Coal");

        assertEquals("Coal", b.cargo);
    }

    @Test
    public void testMultipleAssignments() {
        GoodsBogie b = new GoodsBogie("Cylindrical");

        b.assignCargo("Gas");
        assertEquals("Gas", b.cargo);

        b.assignCargo("Petroleum");
        assertEquals("Petroleum", b.cargo);
    }

    @Test
    public void testExceptionMessage() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        CargoSafetyException e = assertThrows(
                CargoSafetyException.class,
                () -> b.assignCargo("Petroleum")
        );
        assertTrue(e.getMessage().contains("Unsafe"));
    }
}
