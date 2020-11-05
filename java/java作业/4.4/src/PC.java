public class PC {
    private CPU cpu;
    private HardDisk HD;
    public void setCPU(CPU cpu) {
        this.cpu = cpu;
    }

    public void setHD(HardDisk HD) {
        this.HD = HD;
    }
    public void show(){
        System.out.println("CPU speed: " + cpu.getSpeed());
        System.out.println("HardDisk amount: " + HD.getAmount());
    }
}
