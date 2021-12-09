using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ConceptualCameraAPI.Models;

namespace ConceptualCameraAPI.Services
{
    public interface ICameraServices
    {
        Task<List<CameraModel>> GetCamerasAsync();

        Task<CameraDetailsModel> GetCameraDetailsAsync(int _cameraId);

        Task<ImageModel> GetCameraImageAsync(int _cameraId);

        Task<VideoModel> GetCameraVideoAsync(int _cameraId);
    }
}
