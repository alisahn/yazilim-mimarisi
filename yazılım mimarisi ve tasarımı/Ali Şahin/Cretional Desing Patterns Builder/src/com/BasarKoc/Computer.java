package com.BasarKoc;

public class Computer {
    public static class Builder {
        private String computerCase;
        private String CPU;
        private String motherboard;
        private String GPU;
        private String HDD;
        private String operatingSystem;
        private int powerSupply;
        private int amountOfRAM;

        public Builder withCase(String computerCase) {
            this.computerCase = computerCase;
            return this;
        }

        public Builder withCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder withMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder withGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder withHDD(String HDD) {
            this.HDD = HDD;
            return this;
        }

        public Builder withOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Builder withPowerSupply(int powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Builder withAmountOfRam(int amountOfRAM) {
            this.amountOfRAM = amountOfRAM;
            return this;
        }

        public Computer build() {
            Computer computer = new Computer();
            computer.computerCase = this.computerCase;
            computer.CPU = this.CPU;
            computer.motherboard = this.motherboard;
            computer.GPU = this.GPU;
            computer.HDD = this.HDD;
            computer.operatingSystem = this.operatingSystem;
            computer.powerSupply = this.powerSupply;
            computer.amountOfRAM = this.amountOfRAM;

            return computer;
        }
    }

    private Computer() {
        //nothing here
    }

    private String computerCase;
    private String CPU;
    private String motherboard;
    private String GPU;
    private String HDD;
    private String operatingSystem;
    private int powerSupply;
    private int amountOfRAM;

    public Computer(String computerCase, String CPU, String motherboard, String GPU,
                    String HDD, String operatingSystem, int powerSupply, int amountOfRAM) {
        this.computerCase = computerCase;
        this.CPU = CPU;
        this.motherboard = motherboard;
        this.GPU = GPU;
        this.HDD = HDD;
        this.operatingSystem = operatingSystem;
        this.powerSupply = powerSupply;
        this.amountOfRAM = amountOfRAM;
    }

}
