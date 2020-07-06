package com.farheen.devices.api.controller;

import com.farheen.devices.api.entity.Device;
import com.farheen.devices.api.exception.ResourceNotFoundException;
import com.farheen.devices.api.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    //POST MAPPING FOR ONE DEVICE
    @PostMapping("/addDevice")
    public Device addDevice(@RequestBody Device device)
    {
        return deviceService.saveDevice(device);
    }

    //POST MAPPING FOR MORE DEVICES
    @PostMapping("/addDevices")
    public List<Device> addDevices(@RequestBody List<Device> devices)
    {
        return deviceService.saveMoreDevices(devices);
    }

    //GET MAPPING FOR TO GET ONE DEVICE BY ID
    @GetMapping("/deviceById/{deviceId}")
    public Device findDeviceById(@PathVariable int deviceId )
    {
       return deviceService.getDeviceById(deviceId);
    }

    //GET MAPPING FOR TO GET ONE DEVICE BY NAME
    @GetMapping("/deviceByName/{deviceName}")
    public List<Device> findDeviceByName(@PathVariable String deviceName )
    {
        return deviceService.getDeviceByName(deviceName);
    }

    //GET MAPPING FOR TO GET ALL DEVICES
    @GetMapping("/devices")
    public List<Device> findAllDevices()
    {
        return deviceService.getAllDevices();
    }

    //PUT MAPPING
    @PutMapping("/update/{deviceId}")
    public Device modifyDevices(@RequestBody Device device,@PathVariable int deviceId)
    {
        return deviceService.updateDevice(device, deviceId);
    }

    //DELETE MAPPING FOR ONE DEVICE
    @DeleteMapping("/delete/{deviceId}")
    public String deleteDevice(@PathVariable int deviceId)
    {
        return deviceService.deleteDeviceById(deviceId);
    }

    // DELETE MAPPING FOR ALL THE DEVICES
    @DeleteMapping("/deleteAll")
    public String deleteAll()
    {
        return deviceService.deleteAllDevice();
    }

}
