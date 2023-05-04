import request from '@/utils/request';
// 获取人才市场card
export function getJobHuntList(data) {
  return request({
    url: `/jobhunt/getPage`,
    // url: `/recruitment/all?pageNum=${data.pageNum}&pageSize=${data.pageSize}`,
    params: {
      pageNum: data.pageNum,
      pageSize: data.pageSize,
      minSalary: data.minSalary,
      position: data.position,
      positionWorkplace: data.positionWorkplace,
    },
    method: 'get',
  });
}