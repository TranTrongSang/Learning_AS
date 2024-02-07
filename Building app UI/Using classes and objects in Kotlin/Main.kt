import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty



// Parent Class (Super Class)
open class SmartDevice(val name: String, val category: String) {

    
    var deviceStatus = "online"
        protected set 

    open val deviceType = "unknown"

    constructor(name: String, category: String, statusCode: Int): this(name, category){
        deviceStatus = when(statusCode){
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    open fun turnOn(){
        deviceStatus = "on"
    }
    open fun turnOff(){
        deviceStatus = "off"
    }

    fun printDeviceInfo(){
        println("Device name: $name, category: $category, type: $deviceType")
    }
}


// Child Class (Sub Class) - Smart TV
class SmartTvDevice(deviceName: String, deviceCategory: String): SmartDevice(name = deviceName, category = deviceCategory){
    
    override val deviceType = "Smart TV"
    
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
    
    
    fun increaseVolume(){
        speakerVolume += 1
        println("Volume increased to $speakerVolume")
    }

    fun decreaseVolume(){
        speakerVolume -= 1
        println("Volume decreased to $speakerVolume")
    }

    fun nextChannel(){
        channelNumber += 1
        println("Channel changed to $channelNumber")
    }

    fun previousChannel(){
        channelNumber -= 1
        println("Channel changed to $channelNumber")
    }

    override fun turnOn(){
        super.turnOn()
        println("$name is turned on. Volume is $speakerVolume and channel is $channelNumber")
    }

    override fun turnOff(){
        super.turnOff()
        println("$name is turned off.")
    }
}

// Child Class (Sub Class) - Smart Light
class SmartLightDevice(deviceName: String, deviceCategory: String): SmartDevice(name = deviceName, category = deviceCategory){
    
    override val deviceType = "Smart Light"

    private var lightIntensity by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
    
    fun increaseIntensity(){
        lightIntensity += 1
        println("Light intensity increased to $lightIntensity")
    }

    fun decreaseIntensity(){
        lightIntensity -= 1
        println("Light intensity decreased to $lightIntensity")
    }

    override fun turnOn(){
        super.turnOn()
        lightIntensity = 2
        println("$name is turned on. Light intensity is $lightIntensity")
    }

    override fun turnOff(){
        super.turnOff()
        lightIntensity = 0
        println("$name is turned off.")
    }
}


// HAS-A Relationship
class SmartHome(val smartTvDevice: SmartTvDevice, val smartLightDevice: SmartLightDevice){


    var deviceTurnOnCount = 0
        private set

    
    // Smart TV
    fun turnOnTv(){
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }
    fun turnOffTv(){
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }
    fun increaseTvVolume(){
        smartTvDevice.increaseVolume()
    }
    fun decreaseTvVolume(){
        smartTvDevice.decreaseVolume()
    }
    fun nextTvChannel(){
        smartTvDevice.nextChannel()
    }
    fun previousTvChannel(){
        smartTvDevice.previousChannel()
    }
    fun printSmartTvInfo(){
        smartTvDevice.printDeviceInfo()
    }

    // Smart Light
    fun turnOnLight(){
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }
    fun turnOffLight(){
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }
    fun increaseLightIntensity(){
        smartLightDevice.increaseIntensity()
    }
    fun decreaseLightIntensity(){
        smartLightDevice.decreaseIntensity()
    }
    fun printSmartLightInfo(){
        smartLightDevice.printDeviceInfo()
    }
    fun turnOffAllDevices(){
        smartTvDevice.turnOff()
        smartLightDevice.turnOff()
    }
}


class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
): ReadWriteProperty<Any?, Int>{

    var fieldData = initialValue  
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int{
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int){
        if(value in minValue..maxValue){
            fieldData = value
        }
    }
}

fun main(){

    // Smart TV: Volume 2, Channel 1 (Default)
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice.decreaseTvVolume() // Volume decreased to 1
    smartDevice.previousChannel() // Channel changed to 0
    smartDevice.printDeviceInfo()

    println("\n")

    // Smart Light: Intensity 2 (Default)
    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
    smartDevice.decreaseLightIntensity() // Light intensity decreased to 1
    smartDevice.printDeviceInfo()
    println("\n")

}