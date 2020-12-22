export default [
  // application listApplication
  {
    url: "/application/pc/v1/listApplication",
    type: "post",
    response: config => {
      return {
        data: [
          {
            id: 1268442997780377601,
            available: "YES",
            versionDate: "2020-06-04 07:22:33.393",
            recognizeId: "20756ac0-a858-4d3f-9989-f5418dc3866a",
            name: "内部应用1",
            applicationType: "INNER",
            enabled: "YES"
          },
          {
            id: 1268443025580224514,
            available: "YES",
            versionDate: "2020-06-04 07:22:39.890",
            recognizeId: "0e010dfd-f48b-44b0-8f19-2157083d9a30",
            name: "内部应用2",
            applicationType: "INNER",
            enabled: "YES"
          }
        ],
        pageIndex: 1,
        pageSize: 10,
        pageCount: 1,
        total: 2,
        code: "00000",
        description: "成功",
        currentTime: 1591602092687,
        rid: "AynrJyfn"
      };
    }
  },

  {
    url: "/application/pc/v1/get",
    type: "post",
    response: config => {
      return {
        data: [
          {
            id: 1268442997780377601,
            available: "YES",
            versionDate: "2020-06-04 07:22:33.393",
            recognizeId: "20756ac0-a858-4d3f-9989-f5418dc3866a",
            name: "内部应用1",
            applicationType: "INNER",
            enabled: "YES"
          }
        ],
        code: "00000",
        description: "成功",
        currentTime: 1591602092687,
        rid: "AynrJyfn"
      };
    }
  },

  {
    url: "/application/pc/v1/createApplication",
    type: "post",
    response: config => {
      return {
        data: [
          {
            id: 1270152614558253057,
            recognizeId: "470eb8c0-07b9-45d5-903c-2cb3911c2e7a",
            name: "内部应用11",
            applicationType: "INNER",
            secret: "QzBCMjhEMTlDNjNFRTM1RUNDQ0NCNEFCMUMyMjZDNEI=",
            enabled: "YES"
          }
        ],
        code: "00000",
        description: "成功",
        currentTime: 1591662956455,
        rid: "LifKbaKn"
      };
    }
  },

  {
    url: "/application/pc/v1/modifyApplication",
    type: "post",
    response: config => {
      return {
        data: [
          {
            id: 1270152614558253057,
            recognizeId: "470eb8c0-07b9-45d5-903c-2cb3911c2e7a",
            name: "内部应用11",
            applicationType: "INNER",
            enabled: "YES"
          }
        ],
        code: "00000",
        description: "成功",
        currentTime: 1591662956455,
        rid: "LifKbaKn"
      };
    }
  },

  {
    url: "/application/pc/v1/removeApplication",
    type: "get",
    response: config => {
      return {
        data: [true],
        code: "00000",
        description: "成功",
        currentTime: 1591662956455,
        rid: "LifKbaKn"
      };
    }
  },

  {
    url: "/application/pc/v1/resetApplicationSecret",
    type: "get",
    response: config => {
      return {
        data: [
          {
            id: 1267367522282737666,
            available: "YES",
            versionDate: "2020-06-02T18:26:32.916+0000",
            updator: 1267339697195388929,
            creator: 1267339697195388929,
            recognizeId: "48adee8b-a3b5-11ea-be76-00163e142fbd",
            name: "基础数据",
            applicationType: "INNER",
            secret: "QzBCMjhEMTlDNjNFRTM1RUNDQ0NCNEFCMUMyMjZDNEI=",
            enabled: "YES"
          }
        ],
        code: "00000",
        description: "成功",
        currentTime: 1591151192578,
        rid: "pasRnum3"
      };
    }
  },

  {
    url: "/application/pc/v1/exportApplication",
    type: "get",
    response: "@paragraph(2)"
  },

  {
    url: "/application/pc/v1/importApplication",
    type: "post",
    response: config => {
      return {
        data: [true],
        code: "00000",
        description: "成功",
        currentTime: 1591662956455,
        rid: "LifKbaKn"
      };
    }
  }
];
