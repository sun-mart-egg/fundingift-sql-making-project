package consumer;

public class Consumer {

    private Long id; //consumer_id
    private String socialId; //social_id
    private String email; //email
    private String name; //name
    private String profileImageUrl; //profile_image_url
    private String phoneNumber; //phone_number
    private String birthyear; //birthyear, yyyy
    private String birthday; //birthday, mmdd
    private String gender; //gender
    private String createdAt; //created_at
    private String updatedAt; //updated_at
    private String deletedAt; //deleted_at

    public static String getTable() {
        return "consumer";
    }

    public static String getColumns() {
        return "(consumer_id, social_id, email, name, profile_image_url, phone_number, birthyear, birthday, gender, created_at, updated_at, deleted_at)";
    }

    public String getValues() {
        StringBuilder sb = new StringBuilder();

        sb.append("(")
                .append(id).append(", ")
                .append("'").append(socialId).append("', ")
                .append("'").append(email).append("', ")
                .append("'").append(name).append("', ")
                .append("'").append(profileImageUrl).append("', ")
                .append("'").append(phoneNumber).append("', ")
                .append("'").append(birthyear).append("', ")
                .append("'").append(birthday).append("', ")
                .append("'").append(gender).append("', ")
                .append(createdAt).append(", ")
                .append(updatedAt).append(", ")
                .append(deletedAt)
                .append(")");

        return sb.toString();
    }

    private Consumer(Builder builder) {
        this.id = builder.id;
        this.socialId = builder.socialId;
        this.email = builder.email;
        this.name = builder.name;
        this.profileImageUrl = builder.profileImageUrl;
        this.phoneNumber = builder.phoneNumber;
        this.birthyear = builder.birthyear;
        this.birthday = builder.birthday;
        this.gender = builder.gender;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.deletedAt = builder.deletedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String socialId;
        private String email;
        private String name;
        private String profileImageUrl;
        private String phoneNumber;
        private String birthyear;
        private String birthday;
        private String gender;
        private String createdAt;
        private String updatedAt;
        private String deletedAt;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder socialId(String socialId) { this.socialId = socialId; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder profileImageUrl(String profileImageUrl) { this.profileImageUrl = profileImageUrl; return this; }
        public Builder phoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder birthyear(String birthyear) { this.birthyear = birthyear; return this; }
        public Builder birthday(String birthday) { this.birthday = birthday; return this; }
        public Builder gender(String gender) { this.gender = gender; return this; }
        public Builder createdAt(String createdAt) { this.createdAt = createdAt; return this; }
        public Builder updatedAt(String updatedAt) { this.updatedAt = updatedAt; return this; }
        public Builder deletedAt(String deletedAt) { this.deletedAt = deletedAt; return this; }

        public Consumer build() {
            return new Consumer(this);
        }
    }
}
