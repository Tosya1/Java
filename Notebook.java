public class Notebook {
    private String brand;
    private String color;
    private String os;
    private String model;
    private String processor;
    private Integer memory;
    private Integer storage;
    private Integer price;
    private Double display;
    private Integer id;

    public Notebook() {
    }

    public Notebook(Integer id, String brand, String color, String os, Integer price) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.os = os;
        this.price = price;
    }

    public Notebook(String brand, String color, String os, String model,
            String processor, Integer memory, Integer storage, Integer price,
            Double display, Integer id) {
        this.brand = brand;
        this.color = color;
        this.os = os;
        this.model = model;
        this.processor = processor;
        this.memory = memory;
        this.storage = storage;
        this.price = price;
        this.display = display;
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public Double getDisplay() {
        return display;
    }

    public Integer getMemory() {
        return memory;
    }

    public String getOs() {
        return os;
    }

    public String getModel() {
        return model;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public String getProcessor() {
        return processor;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDisplay(Double display) {
        this.display = display;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return brand + " " + color + ", OS: " + os + ", price: " + price;
    }
}
