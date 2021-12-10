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

        Task<ImageModel> GetCameraImageAsync(int _cameraId, string ResponseParameters);

        Task<ImageModel> GetCameraImagesAsync(int _cameraId, DateTime Start, DateTime End, string MetadataParameters, string ResposnseParameters);

        Task<VideoModel> GetCameraVideoAsync(int _cameraId);
    }
}
