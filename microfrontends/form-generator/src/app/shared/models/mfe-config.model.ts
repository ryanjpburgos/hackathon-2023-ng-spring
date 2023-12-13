export interface MfeConfigModel {
  systemParams: SystemParams;
}

export interface SystemParams {
  api: Api;
}

export interface Api {
  'spring-api': SpringApi;
}

export interface SpringApi {
  url: string;
}
