package com.kufed.id.pojo;

/**
 * Created by macbook on 7/21/16.
 */

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoNotifYou {

    @SerializedName("time")
    @Expose
    private Double time;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();

    /**
     * @return The time
     */
    public Double getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(Double time) {
        this.time = time;
    }

    /**
     * @return The status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Content {
        @SerializedName("post_id")
        @Expose
        private String postId;

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        public String getLikeId() {
            return likeId;
        }

        public void setLikeId(String likeId) {
            this.likeId = likeId;
        }

        public String getThumbImagePath() {
            return thumbImagePath;
        }

        public void setThumbImagePath(String thumbImagePath) {
            this.thumbImagePath = thumbImagePath;
        }

        @SerializedName("like_id")

        @Expose
        private String likeId;

        @SerializedName("thumb_image_path")
        @Expose
        private String thumbImagePath;

        @SerializedName("receiver_id")
        @Expose
        private String receiverId;
        @SerializedName("receiver_username")
        @Expose
        private String receiverUsername;
        @SerializedName("member")
        @Expose
        private Member member;

        /**
         * @return The receiverId
         */
        public String getReceiverId() {
            return receiverId;
        }

        /**
         * @param receiverId The receiver_id
         */
        public void setReceiverId(String receiverId) {
            this.receiverId = receiverId;
        }

        /**
         * @return The receiverUsername
         */
        public String getReceiverUsername() {
            return receiverUsername;
        }

        /**
         * @param receiverUsername The receiver_username
         */
        public void setReceiverUsername(String receiverUsername) {
            this.receiverUsername = receiverUsername;
        }

        /**
         * @return The member
         */
        public Member getMember() {
            return member;
        }

        /**
         * @param member The member
         */
        public void setMember(Member member) {
            this.member = member;
        }

    }

    public class Member {

        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("complete_name")
        @Expose
        private String completeName;

        /**
         * @return The username
         */
        public String getUsername() {
            return username;
        }

        /**
         * @param username The username
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         * @return The image
         */
        public String getImage() {
            return image;
        }

        /**
         * @param image The image
         */
        public void setImage(String image) {
            this.image = image;
        }

        /**
         * @return The completeName
         */
        public String getCompleteName() {
            return completeName;
        }

        /**
         * @param completeName The complete_name
         */
        public void setCompleteName(String completeName) {
            this.completeName = completeName;
        }

    }

    public class Datum {

        @SerializedName("activity")
        @Expose
        private String activity;
        @SerializedName("time")
        @Expose
        private Integer time;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("uniq_id")
        @Expose
        private String uniqId;
        @SerializedName("read")
        @Expose
        private Integer read;
        @SerializedName("text")
        @Expose
        private List<String> text = new ArrayList<String>();
        @SerializedName("web_redir_url")
        @Expose
        private String webRedirUrl;
        @SerializedName("content")
        @Expose
        private Content content;

        /**
         * @return The activity
         */
        public String getActivity() {
            return activity;
        }

        /**
         * @param activity The activity
         */
        public void setActivity(String activity) {
            this.activity = activity;
        }

        /**
         * @return The time
         */
        public Integer getTime() {
            return time;
        }

        /**
         * @param time The time
         */
        public void setTime(Integer time) {
            this.time = time;
        }

        /**
         * @return The date
         */
        public String getDate() {
            return date;
        }

        /**
         * @param date The date
         */
        public void setDate(String date) {
            this.date = date;
        }

        /**
         * @return The uniqId
         */
        public String getUniqId() {
            return uniqId;
        }

        /**
         * @param uniqId The uniq_id
         */
        public void setUniqId(String uniqId) {
            this.uniqId = uniqId;
        }

        /**
         * @return The read
         */
        public Integer getRead() {
            return read;
        }

        /**
         * @param read The read
         */
        public void setRead(Integer read) {
            this.read = read;
        }

        /**
         * @return The text
         */
        public List<String> getText() {
            return text;
        }

        /**
         * @param text The text
         */
        public void setText(List<String> text) {
            this.text = text;
        }

        /**
         * @return The webRedirUrl
         */
        public String getWebRedirUrl() {
            return webRedirUrl;
        }

        /**
         * @param webRedirUrl The web_redir_url
         */
        public void setWebRedirUrl(String webRedirUrl) {
            this.webRedirUrl = webRedirUrl;
        }

        /**
         * @return The content
         */
        public Content getContent() {
            return content;
        }

        /**
         * @param content The content
         */
        public void setContent(Content content) {
            this.content = content;
        }

    }

    public class Status {

        @SerializedName("code")
        @Expose
        private Integer code;
        @SerializedName("description")
        @Expose
        private String description;

        /**
         * @return The code
         */
        public Integer getCode() {
            return code;
        }

        /**
         * @param code The code
         */
        public void setCode(Integer code) {
            this.code = code;
        }

        /**
         * @return The description
         */
        public String getDescription() {
            return description;
        }

        /**
         * @param description The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

    }
}
