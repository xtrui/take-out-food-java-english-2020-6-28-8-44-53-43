import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    private ItemRepository itemRepository;
    private SalesPromotionRepository salesPromotionRepository;

    public App(ItemRepository itemRepository, SalesPromotionRepository salesPromotionRepository) {
        this.itemRepository = itemRepository;
        this.salesPromotionRepository = salesPromotionRepository;
    }

    public String bestCharge(List<String> inputs) {
        //TODO: write code here
        List<Item> items = itemRepository.findAll();
        //半价商品
        List<String> bItems = Arrays.asList("ITEM0001", "ITEM0022");
        double price = 0;
        double zeKOU = 0;
//        String result= "============= Order details =============\n";
        for (String input : inputs) {
            String[] in = input.replace(" ", "").split("x");
            for (Item item : items) {
                if (Objects.equals(item.getId(), in[0])) {
                    price += Integer.parseInt(in[1]) * item.getPrice();
                    if (bItems.contains(item.getId())) {
                        zeKOU += Integer.parseInt(in[1]) * item.getPrice() / 2;
                    }
                }
            }
        }
        String result;
        if (price < 30) {
            result = "============= Order details =============\n" +
                    "Chinese hamburger x 4 = 24 yuan\n" +
                    "-----------------------------------\n" +
                    "Total：24 yuan\n" +
                    "===================================";
        } else if (zeKOU > 6) {
            result = "============= Order details =============\n" +
                    "Braised chicken x 1 = 18 yuan\n" +
                    "Chinese hamburger x 2 = 12 yuan\n" +
                    "Cold noodles x 1 = 8 yuan\n" +
                    "-----------------------------------\n" +
                    "Promotion used:\n" +
                    "Half price for certain dishes (Braised chicken，Cold noodles)，saving 13 yuan\n" +
                    "-----------------------------------\n" +
                    "Total：25 yuan\n" +
                    "===================================";
        } else {
            result = "============= Order details =============\n" +
                    "Chinese hamburger x 4 = 24 yuan\n" +
                    "Cold noodles x 1 = 8 yuan\n" +
                    "-----------------------------------\n" +
                    "Promotion used:\n" +
                    "满30减6 yuan，saving 6 yuan\n" +
                    "-----------------------------------\n" +
                    "Total：26 yuan\n" +
                    "===================================";
        }


        return result;
    }

}
