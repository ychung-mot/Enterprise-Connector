using ConceptualCameraAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ConceptualCameraAPI.Data;

namespace ConceptualCameraAPI.Services
{
    public class DummyCameraServices : ICameraServices
    {
        // Instanciate a st of dummy data to use for the API
        private DummyData _data = new DummyData();

        public async Task<CameraDetailsModel> GetCameraDetailsAsync(int _cameraId)
        {
            return await Task.FromResult<CameraDetailsModel>(_data.CameraDetails[_cameraId]);
        }

        public async Task<ImageModel> GetCameraImageAsync(int _cameraId, string _responseParameters)
        {
            if (_responseParameters.ToLower().Contains("thumbnail"))
            {
                return await Task.FromResult<ImageModel>(_data.ThumbnailImages[_cameraId]);
            }
            else
            {
                return await Task.FromResult<ImageModel>(_data.Images[_cameraId]);
            }
        }

        public async Task<ImageModel> GetCameraImagesAsync(int _cameraId, DateTime _start, DateTime _end, string _metadataParameters, string _responseParameters)
        {
            if(_responseParameters.ToLower().Contains("thumbnail"))
            {
                return await Task.FromResult<ImageModel>(_data.ThumbnailImages[_cameraId]);
            }
            else
            {
                return await Task.FromResult<ImageModel>(_data.Images[_cameraId]);
            }
        }

        public async Task<List<CameraModel>> GetCamerasAsync()
        {
            return await Task.FromResult<List<CameraModel>>(_data.Cameras.Values.ToList<CameraModel>());
        }

        public Task<VideoModel> GetCameraVideoAsync(int _cameraId)
        {
            throw new NotImplementedException();
        }
    }
}
