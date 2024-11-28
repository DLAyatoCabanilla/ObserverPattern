class Subscriber implements NewsObserver {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void receiveUpdate(String headline) {
        System.out.println(name + " received breaking news: " + headline);
    }

    @Override
    public String toString() {
        return name;
    }
}
