using ConceptualCameraAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ConceptualCameraAPI.Services
{
    public class CameraServices : ICameraServices
    {
        public async Task<CameraDetailsModel> GetCameraDetailsAsync(int _cameraId)
        {
            throw new NotImplementedException();
        }

        public async Task<ImageModel> GetCameraImageAsync(int _cameraId)
        {
            throw new NotImplementedException();
        }

        public async Task<List<CameraModel>> GetCamerasAsync()
        {
            List<CameraModel> _cameras = new List<CameraModel>();
            _cameras.Add(new CameraModel() { Id = 1, Description = "Westshore", Latitude = 48.41368, Longitude = -123.50720 });
            _cameras.Add(new CameraModel() { Id = 2, Description = "Duncan", Latitude = 48.40075, Longitude = -123.49732 });
            _cameras.Add(new CameraModel() { Id = 3, Description = "Victoria", Latitude = 48.41201, Longitude = -123.41987 });
            _cameras.Add(new CameraModel() { Id = 4, Description = "Hope", Latitude = 47.41368, Longitude = -123.12032 });
            _cameras.Add(new CameraModel() { Id = 5, Description = "Revelstoke", Latitude = 46.41368, Longitude = 122.50720 });
            _cameras.Add(new CameraModel() { Id = 6, Description = "Prince Georgre", Latitude = 46.41368, Longitude = -123.45351 });

            return await Task.FromResult<List<CameraModel>>(_cameras);
        }

        public Task<VideoModel> GetCameraVideoAsync(int _cameraId)
        {
            throw new NotImplementedException();
        }
    }
}
