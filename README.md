# yazilim-mimarisi

## Yazılım Mimarisi Tasarım Ödevi

## Command Pattern Design Komut Tasarım  Deseni
Command design pattern (komut tasarım deseni) behavior grubununa ait, işlemlerin nesne haline getirilip başka bir nesne(invoker) üzerinden tetiklendiği bir tasarım desenidir. Command tasarım deseninin dofactory.com a göre kullanım sıklığı 80% civarındadır.
Command design pattern (komut tasarım deseni), yapılmak istenilen işlemlerin nesneye dönüştürülüp başka bir nesne tarafından bu işlemlerin tetiklenmesi şeklindedir. Command tasarım deseninde, işlem ve işlemin tetiklenmesi yapıları birbirinden ayrılmış olur. İşlemi yapacak nesnenin birden fazla olması durumunda işlemlerin sırayla çalıştırılabilinmesini sağlamış oluruz ve aynı işlem nesnelerini uygulamanın birden fazla yerinde kullanabilir oluruz.

Şimdi biz Kisi sınıfımızı oluşturalım.

```java
public class Kisi {
    public int Id;
    public String ad;
    
    public void setId(int id){
    this.Id=id;
}
    public int getId(){
    return this.Id;
}
    public void setAd(String ad){
    this.ad=ad;
}
    public String getAd(){
    return ad;
}
}
```
Kisi nesnemiz için ekle ve sil işlemlerinin yani metotlarının olduğu, tasarım desenimizde ki Invoker yapısına karşılık gelen ReceiverKisi nesnemizi oluşturalım.
```java
public class ReceiverKisi {
    private Kisi _EntityKisi;
    public ReceiverKisi(Kisi entityKisi){
    this._EntityKisi=entityKisi;
}
    public void Ekle() {
    System.out.Println("Eklendi"+_EntityKisi.ad);
}
    public void Sil() {
    System.out.Println("ID: Silinid",_EntityKisi.Id);
}
}
ReceiverKisi nesnemizde tanımlı olan Ekle() veya Sil() metotlarını çalıştıracak, desenimizdeki Command yapısına karşılık gelen, CommandKisi soyut sınıfımızı oluşturalım.
```java
public abstract class CommandKisi
{
    protected ReceiverKisi _receiverKisi;
    public CommandKisi(ReceiverKisi receiverKisi)
    {
        this._receiverKisi = receiverKisi;
    }
 
    public abstract void Execute();
}
```
```java
public class ConcreteCommandKisiSil extends CommandKisi
{
    public ConcreteCommandKisiSil(ReceiverKisi receiverKisi)
        : base(receiverKisi)
    {
 
    }
 
    public override void Execute()
    {
        _receiverKisi.Sil();
    }
}
 
Şimdi de tasarım desenimizde ki Invoker yapısına karşılık gelen, yani CommandKisi soyut sınıfını kullanan nesnelerin Execute() metodunu çalıştıracak olan InvokerKisi nesnemizi oluşturalım.
    
    public class InvokerKisi
{
    public List<CommandKisi> CommandKisiList { get; set; }
 
    public InvokerKisi()
    {
        CommandKisiList = new List<CommandKisi>();
    }
 
    public void ExecuteAll()
    {
        if (CommandKisiList.Count == 0)
            return;
 
        foreach (CommandKisi item in CommandKisiList)
        {
            item.Execute();
        }
    }
}
 
Son olarak da tasarım desenimizde ki client yapısını oluşturalım.
 ```
 ```java
public class Program
{
    public static void Main(string[] args)
    {
        Kisi Kisi = new Kisi { ID = 1, Ad = "Ahmet" };
 
        ReceiverKisi rk1 = new ReceiverKisi(Kisi);
            
        CommandKisi ckAdd = new ConcreteCommandKisiEkle(rk1);
        CommandKisi ckSil = new ConcreteCommandKisiSil(rk1);
 
        InvokerKisi ik = new InvokerKisi();
 
        ik.CommandKisiList.Add(ckAdd);
        ik.CommandKisiList.Add(ckSil);
 
        ik.ExecuteAll();
 
       
    }
}
 ```


## Cretional Design Patterns Tasarım  Deseni
Yaratımsal tasarım kalıpları, yazılım nesnelerinin nasıl yaratılacağı hakkında genel olarak öneriler sunarak kullandığı esnek yapı sayesinde daha önceden belirlenen durumlara bağlı olarak gerekli nesneleri yaratır. Yaratımsal desenler, hangi nesnenin çağrılması gerektiğini izlemeden sistemin uygun nesneyi çağırmasını sağlayan tasarım kalıplarıdır. Nesnelerin yaratılması gerektiği durumlarda uygulamaya farkedilebilir bir esneklik katar. Esas amaç, iyi bir yazılımın içinde barındırdığı nesnelerin nasıl yaratıldığından bağımsız olarak tasarlanması gerekliliğidir.

```java
public class Computer {
    private String computerCase;
    private String CPU;
    private String motherboard;
    private String GPU;
    private String HDD;
    private String operatingSystem;
    private int powerSupply;
    private int amountOfRAM;
```
Computer classımızın fieldlarını tanımladık.
```java
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
Parametreli yapıcı fonksiyonumuzu oluşturduk.Böyle küçük ve basit bir sınıf bile kurucu gerektirir.Sınıflar oluşuturucu tasarım desenini doğuran bundan çok daha fazla alana sahip olabilir.
Uygulamak için,Computer classı içinde static bir 'Builder' sınıfı yerleştireceğiz.Bu oluşturucu yukarıdaki örnekten farklı olarak nesnelerimiz temiz ve okunabilir bir şekilde oluşturmak için lullanılacaktır.
```java
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
   
    //fields
    //getters and setters
}
```
 
Bu iç içe sınıf,Computer sınıfıyla aynı alanlara sahiptir ve bunları nesnenin kendisini oluşturmak için kullanılır.Computer yapıcısı özel olarak yapılır, böylece onu başlatmanın tek yolu Builder Sınıfıdır.Tüm
Builder kurulumuyla Bilgisayar nesnelerini başlatabiliriz.

 ```java
 public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                .withCase("Tower")
                .withCPU("Intel i5")
                .withMotherboard("MSI B360M-MORTAR")
                .withGPU("nVidia Geforce GTX 750ti")
                .withHDD("Toshiba 1TB")
                .withOperatingSystem("Windows 10")
                .withPowerSupply(500)
                .withAmountOfRam(8)
                .build();
    }
}
``` normalde böyledir ama builder kullandığımızda daha temiz ve daha az olarak görürüz.
```java
public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("Tower", "Intel i5", "MSI B360M-MORTAR",  
        "nVidia GeForce GTX 750ti, "Toshiba 1TB", "Windows 10", 500, 8);
    }
}
Builder kullandığımızda göründüğü gibi daha az daha sade şekilde oldu
