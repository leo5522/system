import request from '@/utils/request';
// 获取招聘信息列表
export function getRecruitmentList(data) {
  return request({
    url: `/recruitment/all`,
    // url: `/recruitment/all?pageNum=${data.pageNum}&pageSize=${data.pageSize}`,
    params: {
      pageNum: data.pageNum,
      pageSize: data.pageSize,
      career: data.career,
      jobtype: data.jobtype,
    },
    method: 'get',
  });
}

// 新增招聘信息
export function addRecruitmentDetail(data) {
  return request({
    url: '/recruitment/save',
    data: {
      ...data,
    },
    method: 'post',
  });
}

// 获取招聘信息
export function getRecruitmentDetail(data) {
  return request({
    url: '/recruitment/getOne',
    data: {
      ...data,
    },
    method: 'post',
  });
}

// 下架招聘信息
export function delRecruitment(data) {
  return request({
    url: '/recruitment/delete',
    data: {
      ...data,
    },
    method: 'post',
  });
}
