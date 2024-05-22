import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void testCheckCart_AllBranches() {
        // Test case: Null item list
        List<Item> itemList = null;
        List<Item> finalItemList = itemList;
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(finalItemList, 100), "Expected RuntimeException for null item list");

        // Test case: Empty item list
        itemList = new ArrayList<>();
        assertTrue(SILab2.checkCart(itemList, 0), "Expected true for empty item list");

        // Test case: Valid item list
        itemList = new ArrayList<>();
        itemList.add(new Item("Item1", "12345", 50, 0.1f));
        itemList.add(new Item("Item2", "67890", 100, 0));
        assertTrue(SILab2.checkCart(itemList, 200), "Expected true for valid item list");

        // Test case: Invalid barcode
        itemList = new ArrayList<>();
        itemList.add(new Item("Item1", "1a2b3c", 50, 0.1f));
        List<Item> finalItemList1 = itemList;
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(finalItemList1, 100), "Expected RuntimeException for invalid barcode");

        // Test case: Price over 300 with discount and barcode starting with zero
        itemList = new ArrayList<>();
        itemList.add(new Item("Item1", "01234", 400, 0.2f));
        assertTrue(SILab2.checkCart(itemList, 350), "Expected true for price over 300 with discount and barcode starting with zero");

        // Test case: Insufficient payment
        itemList = new ArrayList<>();
        itemList.add(new Item("Item1", "12345", 200, 0));
        assertFalse(SILab2.checkCart(itemList, 150), "Expected false for insufficient payment");

        // Test case: Item name is null, should set to "unknown"
        itemList = new ArrayList<>();
        Item nullNameItem = new Item(null, "12345", 50, 0.1f);
        itemList.add(nullNameItem);
        SILab2.checkCart(itemList, 100);
        assertEquals("unknown", nullNameItem.getName(), "Expected item name to be set to 'unknown'");

        // Test case: No barcode
        itemList = new ArrayList<>();
        itemList.add(new Item("Item1", null, 50, 0.1f));
        List<Item> finalItemList2 = itemList;
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(finalItemList2, 100), "Expected RuntimeException for no barcode");
    }

    @Test
    void testCheckCart_MultipleCondition() {
        List<Item> itemList1 = new ArrayList<>();
        itemList1.add(new Item("Item1", "12345", 200, 0));
        assertTrue(SILab2.checkCart(itemList1, 200));

        List<Item> itemList2 = new ArrayList<>();
        itemList2.add(new Item("Item1", "01234", 200, 0));
        assertTrue(SILab2.checkCart(itemList2, 200));

        List<Item> itemList3 = new ArrayList<>();
        itemList3.add(new Item("Item1", "12345", 200, 0.1f));
        assertTrue(SILab2.checkCart(itemList3, 20));

        List<Item> itemList4 = new ArrayList<>();
        itemList4.add(new Item("Item1", "01234", 200, 0.1f));
        assertTrue(SILab2.checkCart(itemList4, 20));

        List<Item> itemList5 = new ArrayList<>();
        itemList5.add(new Item("Item1", "12345", 400, 0));
        assertTrue(SILab2.checkCart(itemList5, 400));

        List<Item> itemList6 = new ArrayList<>();
        itemList6.add(new Item("Item1", "01234", 400, 0));
        assertTrue(SILab2.checkCart(itemList6, 400));

        List<Item> itemList7 = new ArrayList<>();
        itemList7.add(new Item("Item1", "12345", 400, 0.1f));
        assertTrue(SILab2.checkCart(itemList7, 40));

        List<Item> itemList8 = new ArrayList<>();
        itemList8.add(new Item("Item1", "01234", 400, 0.1f));
        assertTrue(SILab2.checkCart(itemList8, 10)); // Expected sum = 40 - 30 = 10
    }
}
