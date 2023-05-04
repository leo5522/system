import request from '@/utils/request';
// 获取企业被投诉列表
export function getComplaintList(data) {
  return request({
    url: `/complaint/getPage`,
    params: {
      pageNum: data.pageNum,
      pageSize: data.pageSize,
      status: data.status,
    },
    method: 'get',
  });
}

// 企业申诉
export function reply(data) {
  return request({
    url: `/complaint/reply`,
    data: {
      ...data,
    },
    method: 'post',
  });
}
