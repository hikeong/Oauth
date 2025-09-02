package Oauth.Oauth.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.Map;
import java.util.HashMap;

@Data
public class OauthToken {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class response{

        private String access_token;
        private String token_type;
        private String refresh_token;
        private long expires_in;
        private String scope;

    }

    @Data
    public static class request {

        @Data
        public static class accessToken {
            public String code;
            private String grant_type;
            private String redirect_uri;

        public void setCode(String code) {
            this.code = code;
        }

        public void setGrant_type(String grant_type) {
            this.grant_type = grant_type;
        }

        public void setRedirect_uri(String redirect_uri) {
            this.redirect_uri = redirect_uri;
        }

            public Map getMapData() {
                Map map = new HashMap();
                map.put("code", code);
                map.put("grant_type", grant_type);
                map.put("redirect_uri", redirect_uri);
                return map;

            }
        }

        @Data
        public static class refreshtoken{
            private String refreshtoken;
            private String grant_type;

            public Map getMapData() {
                Map map = new HashMap();
                map.put("refresh_token", refreshtoken);
                map.put("grant_type", grant_type);
                return map;

            }
        }
    }
}
