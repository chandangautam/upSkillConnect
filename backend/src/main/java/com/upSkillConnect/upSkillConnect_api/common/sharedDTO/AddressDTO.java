package com.upSkillConnect.upSkillConnect_api.common.sharedDTO;

public class AddressDTO {
    private String city;

    private String district;

    private String country;

    private Double latitude;

    private Double longitude;

    private String formattedAddress;

    public AddressDTO() {

    }

    public AddressDTO(String city, String district, String country, Double latitude, Double longitude,
            String formattedAddress) {
        this.city = city;
        this.district = district;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.formattedAddress = formattedAddress;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getCountry() {
        return country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }
}
