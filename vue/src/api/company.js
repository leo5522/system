import request from '@/utils/request';

export function getCompanyDetail() {
  return request({
    url: '/company/getCompany',
    method: 'post',
  });
}

export function saveCompanyDetail(data) {
  return request({
    url: '/company/save',
    data: {
      ...data,
    },
    method: 'post',
  });
}

export function imgUpload() {
  return request({
    url: '/images/upload',
    method: 'post',
  });
}
