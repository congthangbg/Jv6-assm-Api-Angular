app.controller("authority-ctrl", function ($scope, $http, $location) {
   $scope.roles = [];
   $scope.admins = [];
   $scope.authorities = [];

   $scope.initialize = function () {
      //load all roles
      $http.get("/rest/roles").then(response => {
         $scope.roles = response.data;
      });

      //load staff and director (admintrator)
      $http.get("/rest/accounts?admin=true").then(response => {
         $scope.admins = response.data;
      });

      //load authority of staff and director
      $http.get("/rest/authorities/list?admin=true").then(response => {
         $scope.authorities = response.data;
      }).catch(error => {
         $location.path("/unauthorized");
      });

      
   };
 //Khởi đầu
 $scope.initialize();


   $scope.authority_of = function (acc, role) {
      if ($scope.authorities) {
         return $scope.authorities.find(ur => ur.account.username == acc.username && ur.role.id == role.id);
      }
   }

   $scope.authority_changed = function (acc, role) {
      var authority = $scope.authority_of(acc, role);
      if (authority) { //đã cấp quyền ==> thu hồi quyền (xóa q)
         $scope.revoke_authority(authority);
      } else { //chưa được cấp quyền  => cấp quyền (thêm mới)
         authority = { account: acc, role: role };
         $scope.grant_authority(authority);
      }
   }

   //Thêm mới authority
   $scope.grant_authority = function (authority) {
      $http.post(`/rest/authorities/save`, authority).then(response => {
         $scope.authorities.push(response.data);
         alert("Cấp quyền sử dụng thành công");
      }).catch(error => {
         alert("Cấp quyền thất bại!");
         console.log("Error", error);
      })
   }

   //Xóa authority
   $scope.revoke_authority = function (authority) {
      $http.delete(`/rest/authorities/${authority.id}`).then(response => {
         var index = $scope.authorities.findIndex(a => a.id == authority.id);
         $scope.authorities.splice(index, 1);
         alert("Thu hồi quyền sử dụng thành công!");
      }).catch(error => {
         alert("Thu hồi quyền sử dụng thất bại!");
         console.log("Error", error);
      })
   }

})