/**
 * 统一社会信用代码正则表达式 检测旧的15位和新的18位信用代码
 * @param {string} code
 * @returns
 */
export function isUnifiedSocialCreditCode(code) {
  return /^([0-9A-HJ-NPQRTUWXY]{2}\d{6}[0-9A-HJ-NPQRTUWXY]{10}|[1-9]\d{14})$/.test(code);
}

/**
 * 手机号码
 * @param {*} s
 */
export function isMobile(str) {
  return /^1(3|4|5|6|7|8|9)\d{9}$/.test(str);
}

/**
 * 身份证
 * @param {*} s
 */
export function isIDCard(s) {
  return /(^\d{8}(0\d|10|11|12)([0-2]\d|30|31)\d{3}$)|(^\d{6}(18|19|20)\d{2}(0[1-9]|10|11|12)([0-2]\d|30|31)\d{3}(\d|X|x)$)/.test(s);
}

/**
 * @param {string} str
 * @returns {Boolean}
 */
export function validUsername(str) {
  // const valid_map = ['admin', 'editor']
  return str.trim().length > 0;
}
