/*
 * @Description:
 * @Autor: dong jun hua
 * @Date: 2020-07-14 10:47:00
 * @LastEditors: dong jun hua
 * @LastEditTime: 2020-08-10 08:49:59
 */

import axios from "axios";

async function getConfig() {
  try {
    const res = await axios.get("./config.json");
    return res.data;
  } catch (err) {
    console.log(`no config: ${err}`);
    return null;
  }
}

export { getConfig };
