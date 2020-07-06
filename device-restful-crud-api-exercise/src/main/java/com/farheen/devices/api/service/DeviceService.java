package com.farheen.devices.api.service;

import com.farheen.devices.api.entity.Device;
import com.farheen.devices.api.exception.ResourceNotFoundException;
import com.farheen.devices.api.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    /*****POST METHODS******/

    //To create/save one devices
    public Device saveDevice(Device device)
    {
        return deviceRepository.save(device);
    }

    //To create/save list of devices
    public List<Device> saveMoreDevices(List<Device> device)
    {
        return deviceRepository.saveAll(device);
    }

    /*****GET METHODS******/

    //To get one device by id
    public Device getDeviceById(int deviceId)
    {
        return this.deviceRepository.findById(deviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Device Not found with id " + deviceId));
    }

    //To get one device by name
    public List<Device> getDeviceByName(String deviceName)
    {
        return this.deviceRepository.findByDeviceName(deviceName);
    }

    //To get all the list of devices
    public List<Device> getAllDevices()
    {
        return this.deviceRepository.findAll();
    }

    /*****PUT METHODS******/
    public Device updateDevice(Device device, int deviceId)
    {
        Device existingDevice = this.deviceRepository.findById(deviceId).orElseThrow(() -> new ResourceNotFoundException("Device Not found with id " + deviceId));
        existingDevice.setDeviceName(device.getDeviceName());
        existingDevice.setDeviceStatus(device.getDeviceStatus());
        existingDevice.setDeviceModel(device.getDeviceModel());
        existingDevice.setEnrolledTime(device.getEnrolledTime());
        return this.deviceRepository.save(existingDevice);
    }

    /*****DELETE METHODS******/

    //To delete one device
    public String deleteDeviceById(int deviceId)
    {
        this.deviceRepository.deleteById(deviceId);
        return "The device with id " + deviceId + " successfully deleted";
    }

    //To delete all the devices
    public String deleteAllDevice()
    {
        this.deviceRepository.deleteAll();
        return "All the devices enrolled are successfully deleted";
    }
}
