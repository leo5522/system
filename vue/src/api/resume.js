import request from '@/utils/request';
// 获取简历库
export function getResumeList(data) {
  return request({
    url: `/application/getPage`,
    params: {
      pageNum: data.pageNum,
      pageSize: data.pageSize,
      career: data.career,
    },
    method: 'get',
  });
}

// 通过简历
export function Agree(data) {
  return request({
    url: `/application/agree`,
    data: {
      ...data
    },
    method: 'post',
  });
}

// 拒绝简历
export function Refuse(data) {
  return request({
    url: `/application/refuse`,
    data: {
      ...data
    },
    method: 'post',
  });
}


export function appointment(data) {
  return request({
    url: `/application/appointment`,
    data: {
      ...data
    },
    method: 'post',
  });
}

export function pass(data) {
  return request({
    url: `/application/pass`,
    data: {
      ...data
    },
    method: 'post',
  });
}
