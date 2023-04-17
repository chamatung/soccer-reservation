import Api from "./Api";

const apiPrefixUri = "http://localhost:8085/api/s/";

class ApiService {
  //config는 기본 설정를 덮어 씌우고 싶을 떄, 즉 변경하고 싶을 때,
  get(apiUri, params, config) {
    config = config || {};
    config.params = params;
    return Api.get(apiPrefixUri + apiUri, config);
  }

  post(apiUri, data, config) {
    return Api.post(apiPrefixUri + apiUri, data, config);
  }
  //put 전체 업데이트 안준 컬럼은 null
  //patch 주어진 컬럼값만 변경
  //그냥 post로 다 하자

  delete(apiUri, params, config) {
    config = config || {};
    config.params = params;
    return Api.delete(apiPrefixUri + apiUri, config);
  }
}

const apiService = new ApiService();

export default apiService;
