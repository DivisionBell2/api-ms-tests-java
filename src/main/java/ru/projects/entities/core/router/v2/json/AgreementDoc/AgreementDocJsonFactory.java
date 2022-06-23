package ru.projects.entities.core.router.v2.json.AgreementDoc;

public class AgreementDocJsonFactory {
    public static AgreementDocJson getAgreementDocTerms() {
        return AgreementDocJson
                .builder()
                .id(Long.parseLong("1"))
                .agreementType("terms")
                .docDate("2020-12-08T14:41:22.407")
                .type("pdf")
                .bucket("storage-data")
                .uuid("e4f65f5e-36d5-4f79-a701-4bd329d17466/oferta_rbidos_15-09.pdf")
                .link("https://cdn.dasreda.ru/storage-data/e4f65f5e-36d5-4f79-a701-4bd329d17466/oferta_rbidos_15-09.pdf")
                .build();
    }

    public static AgreementDocJson getAgreementDocConsent() {
        return AgreementDocJson
                .builder()
                .id(Long.parseLong("2"))
                .agreementType("consent")
                .docDate("2020-12-08T14:43:12.694")
                .type("pdf")
                .bucket("storage-data")
                .uuid("6be64f3f-6257-4157-9fd0-ed6394f3e4e5/soglasie_na_obrabotku_pdn_vop.pdf")
                .link("https://cdn.dasreda.ru/storage-data/6be64f3f-6257-4157-9fd0-ed6394f3e4e5/soglasie_na_obrabotku_pdn_vop.pdf")
                .build();
    }

    public static AgreementDocJson getAgreementDocConsentFounders() {
        return AgreementDocJson
                .builder()
                .id(Long.parseLong("3"))
                .agreementType("consentFounders")
                .docDate("2020-12-21T13:24:34.899")
                .type("pdf")
                .bucket("storage-data")
                .uuid("6be64f3f-6257-4157-9fd0-ed6394f3e4e5/soglasie_na_obrabotku_pdn_vop.pdf")
                .link("https://cdn.dasreda.ru/storage-data/6be64f3f-6257-4157-9fd0-ed6394f3e4e5/soglasie_na_obrabotku_pdn_vop.pdf")
                .build();
    }

    public static String getSaveAgreementsBody() {
        return "[\n"
                + "  {\n"
                + "    \"type\": \"terms\",\n"
                + "    \"agreed\": true,\n"
                + "    \"docDate\": \"2020-12-08T14:41:22.407\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"type\": \"consent\",\n"
                + "    \"agreed\": true,\n"
                + "    \"docDate\": \"2020-12-08T14:43:12.694\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"type\": \"consentFounders\",\n"
                + "    \"agreed\": true,\n"
                + "    \"docDate\": \"2020-12-21T13:24:34.899\"\n"
                + "  }\n"
                + "]";
    }
}