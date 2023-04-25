import request from '@/utils/request';

export function getCompanyDetail() {
  return request({
    url: '/company/getCompany',
    method: 'post',
  });
}


export function saveCompanyDetail() {
  return request({
    url: '/company/save',
    method: 'post',
  });
}

export function imgUpload() {
  return request({
    url: '/images/upload',
    method: 'post',
  });
}