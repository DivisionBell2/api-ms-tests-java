package ru.projects.allure;

import io.qameta.allure.attachment.AttachmentData;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AdditionAttachmentData implements AttachmentData {

    private final String name;
    private final Map<String, String> urls;

    public AdditionAttachmentData(final String name, final Map<String, String> urls) {
        this.name = name;
        this.urls = urls;
    }

    @Override
    public String getName() {
        return name;
    }

    public static final class Builder {

        private final String name;
        private final Map<String, String> urls = new HashMap<>();

        private Builder(final String name) {
            Objects.requireNonNull(name, "Name must not be null value");
            this.name = name;
        }

        public static AdditionAttachmentData.Builder create(final String attachmentName) {
            return new AdditionAttachmentData.Builder(attachmentName);
        }

        public AdditionAttachmentData.Builder addParams(final String urlName, final String urlValue) {
            Objects.requireNonNull(urlName, "Url name must not be null value");
            this.urls.put(urlName, urlValue);
            return this;
        }

        public AdditionAttachmentData build() {
            return new AdditionAttachmentData(name, urls);
        }
    }
}
