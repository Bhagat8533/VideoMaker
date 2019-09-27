package com.aiii.sdk.android.oss.model;

public enum StorageClass {
    Standard("Standard"),
    IA("IA"),
    Archive("Archive"),
    Unknown("Unknown");
    
    private String storageClassString;

    private StorageClass(String str) {
        this.storageClassString = str;
    }

    public static StorageClass parse(String str) {
        StorageClass[] values;
        for (StorageClass storageClass : values()) {
            if (storageClass.toString().equals(str)) {
                return storageClass;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to parse ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public String toString() {
        return this.storageClassString;
    }
}
