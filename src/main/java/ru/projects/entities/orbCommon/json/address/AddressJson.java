package ru.project.entities.orbCommon.json.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import ru.projects.helpers.assert_helper.AssertHelper;

import javax.validation.constraints.Null;
import java.util.List;

@Builder
@Data
public class AddressJson {
    @Null
    private Long id;
    @Null
    private String result;
    @Null
    @JsonProperty(value = "postal_code", required = true)
    private String postalCode;
    @Null
    @JsonProperty(value = "region_kladr_id", required = true)
    private String regionKladId;
    @Null
    @JsonProperty(value = "region_type_full", required = true)
    private String regionTypeFull;
    @Null
    @JsonProperty(required = true)
    private String region;
    @Null
    @JsonProperty(required = true)
    private String regionCode;
    @Null
    @JsonProperty(value = "area_kladr_id", required = true)
    private String areaKladrId;
    @JsonProperty(value = "area_type_full", required = true)
    @Null
    private String areaTypeFull;
    @Null
    private String area;
    @Null
    @JsonProperty(value = "city_kladr_id", required = true)
    private String cityKladrId;
    @Null
    @JsonProperty(required = true)
    private String city;
    @Null
    @JsonProperty(value = "city_area", required = true)
    private String cityArea;
    @Null
    @JsonProperty(value = "passport_issuer", required = true)
    private String passportIssuer;
    @Null
    @JsonProperty(value = "city_district_kladr_id", required = true)
    private String cityDistrictKladrId;
    @Null
    @JsonProperty(value = "city_district_type_full", required = true)
    private String cityDistrictTypeFull;
    @Null
    @JsonProperty(value = "city_district", required = true)
    private String cityDistrict;
    @Null
    private String country;
    @Null
    @JsonProperty(value = "settlement_kladr_id", required = true)
    private String settlementKladrId;
    @Null
    @JsonProperty(value = "settlement_type_full", required = true)
    private String settlementTypeFull;
    @Null
    private String settlement;
    @Null
    @JsonProperty(value = "street_kladr_id", required = true)
    private String streetKladrId;
    @Null
    @JsonProperty(value = "street_type_full", required = true)
    private String streetTypeFull;
    @Null
    @JsonProperty(required = true)
    private String street;
    @Null
    private String source;
    @Null
    @JsonProperty(value = "house_kladr_id", required = true)
    private String houseKladrId;
    @Null
    @JsonProperty(value = "house_type_full", required = true)
    private String houseTypeFull;
    @Null
    private String house;
    @JsonProperty(value = "block_type_full", required = true)
    @Null
    private String blockTypeFull;
    @Null
    private String block;
    @JsonProperty(value = "flat_type_full", required = true)
    @Null
    private String flatTypeFull;
    @Null
    @JsonProperty(value = "kladr_id", required = true)
    private String kladrId;
    @Null
    @JsonProperty(required = true)
    private String okato;
    @Null
    @JsonProperty(required = true)
    private String oktmo;
    @Null
    @JsonProperty(value = "tax_office", required = true)
    private String taxOffice;
    @Null
    @JsonProperty(value = "tax_office_legal", required = true)
    private String taxOfficeLegal;
    @Null
    @JsonProperty(value = "qc_geo", required = true)
    private String qcGeo;
    @Null
    @JsonProperty(value = "qc_complete", required = true)
    private String qcComplete;
    @Null
    @JsonProperty(value = "qc_house", required = true)
    private Integer qcHouse;
    @Null
    @JsonProperty(required = true)
    private Integer qc;
    @Null
    @JsonProperty(required = true)
    private String created;
    @Null
    @JsonProperty(required = true)
    private String updated;
    @Null
    @JsonProperty(required = true)
    private String flat;
    @Null
    @JsonProperty(value = "flat_type", required = true)
    private String flatType;
    @Null
    @JsonProperty(value = "region_fias_id", required = true)
    private String regionFiasId;
    @Null
    @JsonProperty(value = "region_with_type", required = true)
    private String regionWithType;
    @Null
    @JsonProperty(value = "region_type", required = true)
    private String regionType;
    @Null
    @JsonProperty(value = "area_fias_id", required = true)
    private String areaFiasId;
    @Null
    @JsonProperty(value = "area_with_type", required = true)
    private String areaWithType;
    @Null
    @JsonProperty(value = "beltway_distance", required = true)
    private String beltwayDistance;
    @Null
    @JsonProperty(value = "beltway_hit", required = true)
    private String beltwayHit;
    @Null
    @JsonProperty(value = "block_type", required = true)
    private String blockType;
    @Null
    @JsonProperty(value = "capital_marker", required = true)
    private String capitalMarker;
    @Null
    @JsonProperty(value = "area_type", required = true)
    private String areaType;
    @Null
    @JsonProperty(value = "city_fias_id", required = true)
    private String cityFiasId;
    @Null
    @JsonProperty(value = "city_with_type", required = true)
    private String cityWithType;
    @Null
    @JsonProperty(required = true)
    private Boolean complexAddress;
    @Null
    @JsonProperty(value = "city_type", required = true)
    private String cityType;
    @Null
    @JsonProperty(value = "city_type_full", required = true)
    private String cityTypeFull;
    @Null
    @JsonProperty(value = "settlement_fias_id", required = true)
    private String settlementFiasId;
    @Null
    @JsonProperty(value = "settlement_type", required = true)
    private String settlementType;
    @Null
    @JsonProperty(value = "settlement_with_type", required = true)
    private String settlementWithType;
    @Null
    @JsonProperty(value = "street_fias_id", required = true)
    private String streetFiasId;
    @Null
    @JsonProperty(value = "street_type", required = true)
    private String streetType;
    @Null
    @JsonProperty(value = "street_with_type", required = true)
    private String streetWithType;
    @Null
    @JsonProperty(value = "house_fias_id", required = true)
    private String houseFiasId;
    @Null
    @JsonProperty(value = "house_type", required = true)
    private String houseType;
    @Null
    @JsonProperty(value = "flat_area", required = true)
    private String flatArea;
    @Null
    @JsonProperty(value = "flat_price", required = true)
    private String flatPrice;
    @Null
    @JsonProperty(value = "geo_lat", required = true)
    private String geoLat;
    @Null
    @JsonProperty(value = "geo_lon", required = true)
    private String geoLon;
    @Null
    @JsonProperty(value = "history_values", required = true)
    private List<String> historyValues;
    @Null
    @JsonProperty(value = "square_meter_price", required = true)
    private String squareMeterPrice;
    @Null
    @JsonProperty(value = "postal_box", required = true)
    private String postalBox;
    @Null
    @JsonProperty(value = "fias_id", required = true)
    private String fiasId;
    @Null
    @JsonProperty(value = "fias_level", required = true)
    private String fiasLevel;
    @Null
    @JsonProperty(required = true)
    private String timezone;
    @Null
    @JsonProperty(value = "unparsed_parts", required = true)
    private String unparsedParts;
    @Null
    @JsonProperty(required = true)
    private String room;
    @Null
    @JsonProperty(value = "area_zone_type_full", required = true)
    private String areaZoneTypeFull;
    @Null
    @JsonProperty(value = "area_zone", required = true)
    private String areaZone;
    @Null
    @JsonProperty(value = "block_type_full_1", required = true)
    private String blockTypeFull1;
    @Null
    @JsonProperty(value = "block_1", required = true)
    private String block1;
    @Null
    @JsonProperty(value = "room_type_full", required = true)
    private String roomTypeFull;
    @Null
    @JsonProperty(value = "oktmo_area_type", required = true)
    private String oktmoAreaType;
    @Null
    @JsonProperty(value = "oktmo_area_code", required = true)
    private String oktmoAreaCode;
    @Null
    @JsonProperty(value = "oktmo_area", required = true)
    private String oktmoArea;
    @Null
    @JsonProperty(value = "oktmo_subarea_type", required = true)
    private String oktmoSubareaType;
    @Null
    @JsonProperty(value = "oktmo_subarea_code", required = true)
    private String oktmoSubareaCode;
    @Null
    @JsonProperty(value = "oktmo_subarea", required = true)
    private String oktmoSubarea;
    @Null
    @JsonProperty(required = true)
    private String building;
    @Null
    @JsonProperty(value = "building_type", required = true)
    private String buildingType;
    @Null
    @JsonProperty(value = "building_type_full", required = true)
    private String buildingTypeFull;
    @Null
    @JsonProperty(value = "planning_structure", required = true)
    private String planningStructure;
    @Null
    @JsonProperty(value = "planning_structure_fias_id", required = true)
    private String planningStructureFiasId;
    @Null
    @JsonProperty(value = "planning_structure_kladr_id", required = true)
    private String planningStructureKladrId;
    @Null
    @JsonProperty(value = "planning_structure_type", required = true)
    private String planningStructureType;
    @Null
    @JsonProperty(value = "planning_structure_type_full", required = true)
    private String planningStructureTypeFull;
    @Null
    @JsonProperty(value = "planning_structure_with_type", required = true)
    private String planningStructureWithType;

    public void compareTo(AddressJson address) {
        AssertHelper.assertEquals(this.getPostalCode(), address.getPostalCode());
        AssertHelper.assertEquals(this.getRegionKladId(), address.getRegionKladId());
        AssertHelper.assertEquals(this.getRegionTypeFull(), address.getRegionTypeFull());
        AssertHelper.assertEquals(this.getRegion(), address.getRegion());
        AssertHelper.assertEquals(this.getStreetKladrId(), address.getStreetKladrId());
        AssertHelper.assertEquals(this.getStreetTypeFull(), address.getStreetTypeFull());
        AssertHelper.assertEquals(this.getHouseKladrId(), address.getHouseKladrId());
        AssertHelper.assertEquals(this.getHouseTypeFull(), address.getHouseTypeFull());
        AssertHelper.assertEquals(this.getHouse(), address.getHouse());
        AssertHelper.assertEquals(this.getKladrId(), address.getKladrId());
        AssertHelper.assertEquals(this.getOkato(), address.getOkato());
        AssertHelper.assertEquals(this.getOktmo(), address.getOktmo());
        AssertHelper.assertEquals(this.getTaxOffice(), address.getTaxOffice());
        AssertHelper.assertEquals(this.getTaxOfficeLegal(), address.getTaxOfficeLegal());
    }
}