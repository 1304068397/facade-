/*
 * @Description:
 * @Autor: dong
 * @Date: 2020-03-13 10:03:57
 * @LastEditors: dong
 * @LastEditTime: 2020-04-13 09:00:20
 */

// import parseTime, formatTime and set to filter
export { parseTime, formatTime } from "@/utils";
import moment from "moment"; // moment

/**
 * Show plural label if time is plural number
 * @param {number} time
 * @param {string} label
 * @return {string}
 */
function pluralize(time, label) {
  if (time === 1) {
    return time + label;
  }
  return time + label + "s";
}

/**
 * @param {number} time
 */
export function timeAgo(time) {
  const between = Date.now() / 1000 - Number(time);
  if (between < 3600) {
    return pluralize(~~(between / 60), " minute");
  } else if (between < 86400) {
    return pluralize(~~(between / 3600), " hour");
  } else {
    return pluralize(~~(between / 86400), " day");
  }
}

/**
 * date formatting
 * @method: dateFormatter
 * @param {String} date 日期
 * @param {String} pattern 格式化字符串
 * @return {String}
 */
export function dateFormatter(date, pattern = "YYYY-MM-DD HH:mm:ss") {
  return moment(date).format(pattern);
}

/**
 * money formatting
 * @method: moneyFormatter
 * @param {Number} number 要格式化的数字
 * @param {Number} decimals 保留几位小数
 * @param {String} thousandsSep 千分位符号
 * @return {String}
 */
export function moneyFormatter(number, decimals, thousandsSep = "") {
  number = (number + "").replace(/[^0-9+-Ee.]/g, "");
  const n = !isFinite(+number) ? 0 : +number,
    prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
    toFixedFix = function(n, prec) {
      const k = Math.pow(10, prec);
      return "" + Math.ceil(n * k) / k;
    };

  const s = (prec ? toFixedFix(n, prec) : "" + Math.round(n)).split(".");
  const re = /(-?\d+)(\d{3})/;
  while (re.test(s[0]) && thousandsSep) {
    s[0] = s[0].replace(re, `$1${thousandsSep}$2`);
  }

  if ((s[1] || "").length < prec) {
    s[1] = s[1] || "";
    s[1] += new Array(prec - s[1].length + 1).join("0");
  }
  return s.join(".");
}

/**
 * Number formatting
 * like 10000 => 10k
 * @param {number} num
 * @param {number} digits
 */
export function numberFormatter(num, digits) {
  const si = [
    { value: 1e18, symbol: "E" },
    { value: 1e15, symbol: "P" },
    { value: 1e12, symbol: "T" },
    { value: 1e9, symbol: "G" },
    { value: 1e6, symbol: "M" },
    { value: 1e3, symbol: "k" }
  ];
  for (let i = 0; i < si.length; i++) {
    if (num >= si[i].value) {
      return (
        (num / si[i].value)
          .toFixed(digits)
          .replace(/\.0+$|(\.[0-9]*[1-9])0+$/, "$1") + si[i].symbol
      );
    }
  }
  return num.toString();
}

/**
 * 10000 => "10,000"
 * @param {number} num
 */
export function toThousandFilter(num) {
  return (+num || 0)
    .toString()
    .replace(/^-?\d+/g, m => m.replace(/(?=(?!\b)(\d{3})+$)/g, ","));
}

/**
 * Upper case first char
 * @param {String} string
 */
export function uppercaseFirst(string) {
  return string.charAt(0).toUpperCase() + string.slice(1);
}
