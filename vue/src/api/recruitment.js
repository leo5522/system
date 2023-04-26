import request from '@/utils/request';

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

export function addRecruitmentDetail(data) {
  return request({
    url: '/recruitment/save',
    data: {
      ...data,
    },
    method: 'post',
  });
}
