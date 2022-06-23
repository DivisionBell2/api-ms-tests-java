package ru.project.entities.orbCommon.json.address;

public class AddressJsonFactory {

    public static AddressJson getAddressJson() {
        return AddressJson
                .builder()
                .area("Первомайское")
                .areaKladrId("7701400000000")
                .areaTypeFull("поселение")
                .block("1")
                .blockTypeFull("строение")
                .city("Москва")
                .cityArea("Троицкий")
                .cityDistrict("Троицкий")
                .cityKladrId("7700000000000")
                .cityTypeFull("город")
                .complexAddress(false)
                .flat("1")
                .flatType("квартира")
                .flatTypeFull("квартира")
                .house("24A")
                .houseKladrId("7701400002300050021")
                .houseTypeFull("дом")
                .kladrId("7701400002300050021")
                .okato("45298572112")
                .oktmo("45955000")
                .postalCode("143396")
                .qcGeo("0")
                .region("Москва")
                .regionCode("77")
                .regionKladId("7700000000000")
                .regionTypeFull("город")
                .settlement("Клоково")
                .settlementKladrId("7701400002300")
                .settlementTypeFull("деревня")
                .street("Новопеределкинская")
                .streetKladrId("77014000023000500")
                .streetTypeFull("улица")
                .taxOffice("7751")
                .taxOfficeLegal("7751")
                .build();
    }

    public static AddressJson getAddressJsonVersion2() {
        return AddressJson
                .builder()
                .city("Омск")
                .cityKladrId("5500000100000")
                .cityTypeFull("город")
                .complexAddress(false)
                .flat("15")
                .flatType("квартира")
                .flatTypeFull("квартира")
                .house("3")
                .houseType("д")
                .houseKladrId("5500000100004310040")
                .houseTypeFull("дом")
                .kladrId("5500000100004310040")
                .okato("52401376000")
                .oktmo("52701000001")
                .oktmoArea("город Омск")
                .oktmoAreaCode("52701000")
                .oktmoAreaType("2")
                .postalCode("644041")
                .region("Омская")
                .regionCode("55")
                .regionKladId("5500000000000")
                .regionTypeFull("область")
                .street("Кирова")
                .streetKladrId("55000001000043100")
                .streetTypeFull("улица")
                .taxOffice("5506")
                .taxOfficeLegal("5506")
                .build();
    }

    public static AddressJson getAddressJsonWithFlatAndRoom(AddressJson address) {
        address.setFlat("1");
        address.setFlatTypeFull("Квартира");
        address.setRoom("1");
        address.setRoomTypeFull("Комната");

        return address;
    }

    public static FullRegistryAddressJson getFullRegistrationAddress(AddressJson address) {
        return FullRegistryAddressJson.builder().
                fullRegistryAddress(address).
                build();
    }
}